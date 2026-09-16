import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Converts XML "Z??" tags (e.g. <ZMR>, <ZCD>, <ZID>, <ZM1>) whose name is a single 'Z'
 * followed by exactly two letters or digits into <ZSEGMENT> ... </ZSEGMENT>.
 *
 * The value of the first <UNKNOWN.1> child is placed in a <ZID> child tag.
 * The remaining text from all child/descendant elements is merged into a single
 * space-separated string inside a <ZVALUE> child tag.
 *
 * Tags like <ZMR.1> or <ZCD.2> are left unchanged because their names contain
 * more than two characters after the leading 'Z'.
 *
 * Usage:
 *   javac ZSegmentConverter.java
 *   java ZSegmentConverter z.xml z-converted.xml
 */
public class ZSegmentConverter {

	// Matches a start/end tag pair where the tag name is Z + exactly two letters or digits.
	// The negative lookahead ensures we do not match longer names like ZMR.1 or ZABC.
	private static final Pattern Z_TAG_PATTERN = Pattern.compile(
		"<(Z[A-Za-z0-9]{2})(?![A-Za-z0-9._-])[^>]*>(.*?)</\\1>",
		Pattern.DOTALL
	);

	public static String convert(String xml) {
		Matcher matcher = Z_TAG_PATTERN.matcher(xml);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			String content = matcher.group(2);
			String unknown1 = extractUnknown1(content);
			String merged = mergeChildTexts(content, unknown1);
			String replacement = unknown1 != null
					? "<ZSEGMENT><ZID>" + unknown1 + "</ZID><ZVALUE>" + merged + "</ZVALUE></ZSEGMENT>"
					: "<ZSEGMENT><ZVALUE>" + merged + "</ZVALUE></ZSEGMENT>";
			matcher.appendReplacement(sb, Matcher.quoteReplacement(replacement));
		}
		matcher.appendTail(sb);
		return sb.toString();
	}

	private static String extractUnknown1(String content) {
		Matcher m = Pattern.compile("<UNKNOWN\\.1>([^<]+)</UNKNOWN\\.1>").matcher(content);
		return m.find() ? m.group(1).trim() : null;
	}

	private static String mergeChildTexts(String content, String exclude) {
		Matcher m = Pattern.compile(">([^<]*?)<").matcher(content);
		List<String> parts = new ArrayList<>();
		while (m.find()) {
			String part = m.group(1).trim();
			if (part.isEmpty() || (exclude != null && part.equals(exclude))) {
				continue;
			}
			parts.add(part);
		}
		return String.join(" ", parts);
	}

	public static void main(String[] args) throws IOException {
		String input = args.length > 0 ? args[0] : "z.xml";
		String output = args.length > 1 ? args[1] : "z-converted.xml";

		Path inputPath = Paths.get(input);
		String original = new String(Files.readAllBytes(inputPath), StandardCharsets.UTF_8);
		String converted = convert(original);

		Files.write(Paths.get(output), converted.getBytes(StandardCharsets.UTF_8));
		System.out.println("Wrote converted XML to " + output);
	}
}
