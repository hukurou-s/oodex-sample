JAVAC      = javac
JAVA       = java
MAIN       = main.java.Main
SOURCES    = $(wildcard src/main/**/*.java)
FLAGS      = -encoding UTF-8 -Xlint:deprecation -J-Dfile.encoding=UTF-8
CLASS_PATH = -classpath src/
BUILD_DIR  = bin/
BUILD_PATH = -d $(BUILD_DIR)
EXEC_FLAGS = -classpath $(BUILD_DIR)
MAKEFLAGS += --silent

compile:
	@[ -d $(BUILD_DIR) ] || mkdir -p $(BUILD_DIR)
	$(JAVAC) $(FLAGS) $(CLASS_PATH) $(BUILD_PATH) $(SOURCES)

exec: clean compile
	$(JAVA) $(EXEC_FLAGS) $(MAIN)

.PHONY: clean
clean:
	-rm -rf $(BUILD_DIR)
