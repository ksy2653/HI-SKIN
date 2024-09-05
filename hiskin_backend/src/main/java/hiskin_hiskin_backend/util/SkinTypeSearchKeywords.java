package hiskin_hiskin_backend.util;

public enum SkinTypeSearchKeywords {
    ORPT("미백탄력"),
    ORPW("안티에이징"),
    ORNT("피지순삭"),
    ORNW("보습주름"),
    OSPT("민감"),
    OSPW("예민토너"),
    OSNT("여드름"),
    OSNW("지성주름"),
    DRPT("보습"),
    DRPW("주름토너"),
    DRNT("히알루론산 크림"),
    DRNW("피부탄력"),
    DSPT("색소침착"),
    DSPW("감초 추출물"),
    DSNT("보습탄력 에멀젼"),
    DSNW("각질");

    private final String keyword;

    SkinTypeSearchKeywords(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }
}
