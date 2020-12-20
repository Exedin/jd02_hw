add web-apps to jd02_hw\git1\task_11_12_13\
$ git status
On branch master
Your branch is up to date with 'origin/master'.

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        git1/

nothing added to commit but untracked files present (use "git add" to track)

$ git add git1/

$ git status
On branch master
Your branch is up to date with 'origin/master'.

Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        new file:   git1/task_11_12_13/readme.txt
        new file:   git1/task_11_12_13/tomcat-quickstart/pom.xml
        new file:   git1/task_11_12_13/tomcat-quickstart/src/main/java/it/academy/servlet/EchoServlet.java

$ git commit
[master 73f23d6] added project tomcat-quickstart for git-tasks
 3 files changed, 80 insertions(+)
 create mode 100644 git1/task_11_12_13/readme.txt
 create mode 100644 git1/task_11_12_13/tomcat-quickstart/pom.xml
 create mode 100644 git1/task_11_12_13/tomcat-quickstart/src/main/java/it/academy/servlet/EchoServlet.java


$ git push origin master
Enumerating objects: 15, done.
Counting objects: 100% (15/15), done.
Delta compression using up to 8 threads
Compressing objects: 100% (6/6), done.
Writing objects: 100% (14/14), 1.73 KiB | 1.73 MiB/s, done.
Total 14 (delta 0), reused 0 (delta 0), pack-reused 0
To https://github.com/Exedin/jd02_hw.git
   e221793..73f23d6  master -> master

$ git branch testBranch

$ git checkout testBranch
Switched to branch 'testBranch'

$ cd git1/task_11_12_13/tomcat-quickstart/src/main/java/it/academy/servlet

$ vim Echoservlet.java

change text "writer.println("Hello from Echo servlet!"+ new Date());" to  "writer.println("Hello from Echo servlet! It's test branch"+ new Date());"

$ git commit -a -m "test branch"
[master e80fd0c] master branch
 1 file changed, 1 insertion(+), 1 deletion(-)

$ git branch master

$ vim Echoservlet.java

change text "writer.println("Hello from Echo servlet!"+ new Date());" to  "writer.println("Hello from Echo servlet! It's master branch "+ new Date());"

$ git commit -a -m "master branch"
[master e80fd0c] master branch
 1 file changed, 1 insertion(+), 1 deletion(-)

$ git merge testBranch
Auto-merging git1/task_11_12_13/tomcat-quickstart/src/main/java/it/academy/servlet/EchoServlet.java
CONFLICT (content): Merge conflict in git1/task_11_12_13/tomcat-quickstart/src/main/java/it/academy/servlet/EchoServlet.java
Automatic merge failed; fix conflicts and then commit the result.

change text to  "writer.println("Hello from Echo servlet!"+ new Date());"

$ git push origin master
Enumerating objects: 48, done.
Counting objects: 100% (48/48), done.
Delta compression using up to 8 threads
Compressing objects: 100% (16/16), done.
Writing objects: 100% (37/37), 2.55 KiB | 871.00 KiB/s, done.
Total 37 (delta 4), reused 0 (delta 0), pack-reused 0
remote: Resolving deltas: 100% (4/4), completed with 1 local object.
To https://github.com/Exedin/jd02_hw.git
   1635908..1ead289  master -> master

=================
Task 13
$ vim EchoServlet.java

$ git commit -a -m "task 13 commit"
[master 0331bae] task 13 commit
 1 file changed, 1 insertion(+), 1 deletion(-)

change text "writer.println("Hello from Echo servlet!"+ new Date());" to  "writer.println("Hello from Echo servlet! It's task 13"+ new Date());"

$ git reset --hard
HEAD is now at d354dbd task 13 commit
