package org.znaji;

public interface TextProcessorStrategy {
    String process(String text);
    default TextProcessorStrategy combine(TextProcessorStrategy after) {
        return text -> this.process(after.process(text));
    }
}
