#!/bin/sh

# This is how to release a version - update the version number, e.g. ./release 0.0.1
VERSION=${1:?no version supplied}

echo "Publishing tagged version v${VERSION}..."

git tag -a "v${VERSION}" -m "Release v${VERSION}"
git push origin "v${VERSION}"
