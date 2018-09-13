find . -name "*.java" > sources.txt
javac -classpath . @sources.txt
java avajlauncher.simulator.Simu scenario.txt
find . -name "*.class" -delete
