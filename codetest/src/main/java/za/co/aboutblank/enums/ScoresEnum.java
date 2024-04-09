package za.co.aboutblank.enums;

public enum ScoresEnum {
    RANK_ACEs_LOW (1),
    RANK_2 ( 2),
    RANK_3 (3),
    RANK_4 (4),
    RANK_5 (5),
    RANK_6 (6),
    RANK_7(7),
    RANK_8 (8),
    RANK_9 (9),
    RANK_10 (10),
    RANK_JACK (11),
    RANK_QUEEN (12),
    RANK_KING (13),
    RANK_ACE_HIGH(14),
    RANK_WILDCARD (20);

    private final int rank;
    
    private ScoresEnum(int rank) {
        this.rank = rank;
    }
    
    public int getScoresEnum() {
        return rank;
    } 
}
