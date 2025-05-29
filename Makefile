JAR_NAME = UtilityBox.jar
SRC_DIR = src
OUT_DIR = out
DATA_DIR = data
MAIN_CLASS = utilitybox.Main
MANIFEST = manifest.txt

.PHONY: all clean jar

all: $(JAR_NAME)

$(JAR_NAME): clean compile copydata manifest
	jar cfm $(JAR_NAME) $(MANIFEST) -C $(OUT_DIR) .

compile:
	javac -d $(OUT_DIR) $(SRC_DIR)/utilitybox/*.java

copydata:
	cp -r $(DATA_DIR) $(OUT_DIR)/

manifest:
	echo "Main-Class: $(MAIN_CLASS)" > $(MANIFEST)

clean:
	rm -rf $(OUT_DIR) $(JAR_NAME) $(MANIFEST)
	mkdir -p $(OUT_DIR)

