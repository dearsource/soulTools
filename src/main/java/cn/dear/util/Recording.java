package cn.dear.util;

/**
 * 功能描述
 *
 * @since 2021-02-24
 */
public class Recording {
    private Long start;

    private Long now;

    public Recording() {
    }

    public Recording(Long start, Long now) {
        this.start = start;
        this.now = now;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getNow() {
        return now;
    }

    public void setNow(Long now) {
        this.now = now;
    }
}
