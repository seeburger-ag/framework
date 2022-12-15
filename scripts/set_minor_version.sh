#!/bin/bash

if [ $1 ]; then

echo "************************************"
echo " Setting version to 8.$1-SNAPSHOT"
echo "************************************"

mvn versions:set -DnewVersion=7.$1-SNAPSHOT -DprocessAllModules=true -DgenerateBackupPoms=false
cd bom && mvn versions:set -DnewVersion=7.$1-SNAPSHOT -DprocessAllModules=true -DgenerateBackupPoms=false

else

echo "Usage: $0 new_minor"
echo "e.g. $0 20  # new version set to 7.20-SNAPSHOT"

fi

