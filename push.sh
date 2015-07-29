#Test Script

clear
git status
git add --all
echo "Enter commit message"
read COM
git commit -m $COM
git push
