#!/bin/bash

TAG=$1

if [ -z "$TAG" ]; then
  echo "❌ Usage: ./scripts/check-before-release.sh vX.Y.Z"
  exit 1
fi

echo "🔍 Checking release requirements for tag $TAG..."

# Check changelog
if grep -q "^## \[$TAG\]" CHANGELOG.md; then
  echo "✅ Found changelog section for $TAG"
else
  echo "❌ Missing changelog section for $TAG in CHANGELOG.md"
  exit 1
fi

# Check versionName and versionCode
VERSION_NAME=$(grep 'versionName' composeApp/build.gradle.kts | sed -E 's/.*"(.+)".*/\1/')
VERSION_CODE=$(grep 'versionCode' composeApp/build.gradle.kts | sed -E 's/[^0-9]*([0-9]+).*/\1/')

if [ -n "$VERSION_NAME" ] && [ -n "$VERSION_CODE" ]; then
  echo "✅ Found versionName=$VERSION_NAME and versionCode=$VERSION_CODE"
  echo "🔎 Make sure these values are updated compared to the previous release!"
else
  echo "❌ versionName or versionCode is missing or invalid"
  exit 1
fi

echo "🎉 All checks passed. You can now create and push the tag $TAG."
