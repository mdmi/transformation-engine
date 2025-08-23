import os

new_license = """/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
"""

for root, _, files in os.walk("."):
    for file in files:
        if file.endswith(".java"):
            path = os.path.join(root, file)
            with open(path, "r", encoding="utf-8") as f:
                content = f.read()

            if content.startswith("/*"):
                # Replace the first comment block
                content = new_license + content.split("*/", 1)[1].lstrip()
            else:
                # Insert if no license
                content = new_license + "\n" + content

            with open(path, "w", encoding="utf-8") as f:
                f.write(content)

