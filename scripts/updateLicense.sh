#!/bin/bash

if [ $1 ]; then
    echo "Using arguments $@"
    python3 scripts/licenseheaders.py -E java -vv $@
else
    echo "***************************************";
    echo "* Update license header in Java files *";
    echo "***************************************";
    echo "";
    echo "Uses LicenseHeaders 0.8.8 by Johann Petrak";
    echo "";
    echo "Run this script in the project root, e.g.";
    echo '$ sh scripts/updateLicense.sh -y 2000-2022 -t license.tmpl';
    echo "where";
    echo "   -y <year> is the copyright year or year range and";
    echo "   -t <template_file> is the license template to use";
    echo "";
    echo "You may also want to use the --dry argument to not have";
    echo "the script write changes directly to the files.";
    echo "";
fi
