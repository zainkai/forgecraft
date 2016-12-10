#Test Script

clear
git status
git add --all
IFS= read -r -p "Enter commit message: " com
git commit -m "$com"
git push
