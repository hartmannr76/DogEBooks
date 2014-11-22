package enums;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ricky
 */
public enum Category {
    ART_ANTIQUES_COLLECTIBLES("Art, Antiques & Collectibles", 1),
    BIOGRAPHY("Biography", 2),
    BUSINESS_INVESTING("Business & Investing", 3),
    CAREERS_INVESTING("Careers & Employment", 4),
    CLASSIC_LITERATURE("Classic Literature", 5),
    COMPUTERS_TECHNOLOGY("Computers & Technology", 6),
    COOKING_FOOD("Cooking & Food", 7),
    CURRENT_EVENTS_POLITICS("Current Events & Politics", 8),
    DRAMA("Drama", 9),
    FOREIGN_LANGUAGE_STUDY("Foreign Language Study", 10),
    HEALTH_FITNESS("Health & Fitness", 11),
    HISTORICAL_FICTION("Historical Fiction", 12),
    HISTORY("History", 13),
    HOME_FAMILY("Home & Family", 14),
    HORROR("Horror", 15),
    HUMOR("Humor", 16),
    LITERARY_CRITICISM("Literary Criticism", 17),
    MYSTERY("Mystery", 18),
    POETRY("Poetry", 19),
    PROFESSIONAL("Professional", 20),
    RELIGION_SPIRITUALITY("Religion & Spirituality", 21),
    ROMANCE("Romance", 22),
    SCIENCE_FICTION_FANTASY("Science Fiction & Fantasy", 23),
    SELF_IMPROVEMENT("Self-Improvement", 24),
    SPORTS_RECREATION("Sports & Recreations", 25),
    STUDY_AIDS_REFERENCE("Study Aids & Reference", 26),
    SUSPENSE_THRILLERS("Suspense & Thrillers", 27),
    TRAVEL("Travel", 28),
    WESTERN("Western", 29),
    AUDIOBOOK_ART_ANTIQUES_COLLECTIBLES("Art, Antiques & Collectibles", 30),
    AUDIOBOOK_BIOGRAPHY("Biography", 31),
    AUDIOBOOK_BUSINESS_INVESTING("Business & Investing", 32),
    AUDIOBOOK_CAREERS_INVESTING("Careers & Employment", 33),
    AUDIOBOOK_CLASSIC_LITERATURE("Classic Literature", 34),
    AUDIOBOOK_COMPUTERS_TECHNOLOGY("Computers & Technology", 35),
    AUDIOBOOK_COOKING_FOOD("Cooking & Food", 36),
    AUDIOBOOK_CURRENT_EVENTS_POLITICS("Current Events & Politics", 37),
    AUDIOBOOK_DRAMA("Drama", 38),
    AUDIOBOOK_FOREIGN_LANGUAGE_STUDY("Foreign Language Study", 39),
    AUDIOBOOK_HEALTH_FITNESS("Health & Fitness", 40),
    AUDIOBOOK_HISTORICAL_FICTION("Historical Fiction", 41),
    AUDIOBOOK_HISTORY("History", 42),
    AUDIOBOOK_HOME_FAMILY("Home & Family", 43),
    AUDIOBOOK_HORROR("Horror", 44),
    AUDIOBOOK_HUMOR("Humor", 45),
    AUDIOBOOK_LITERARY_CRITICISM("Literary Criticism", 46),
    AUDIOBOOK_MYSTERY("Mystery", 47),
    AUDIOBOOK_POETRY("Poetry", 48),
    AUDIOBOOK_PROFESSIONAL("Professional", 49),
    AUDIOBOOK_RELIGION_SPIRITUALITY("Religion & Spirituality", 50),
    AUDIOBOOK_ROMANCE("Romance", 51),
    AUDIOBOOK_SCIENCE_FICTION_FANTASY("Science Fiction & Fantasy", 52),
    AUDIOBOOK_SELF_IMPROVEMENT("Self-Improvement", 53),
    AUDIOBOOK_SPORTS_RECREATION("Sports & Recreations", 54),
    AUDIOBOOK_STUDY_AIDS_REFERENCE("Study Aids & Reference", 55),
    AUDIOBOOK_SUSPENSE_THRILLERS("Suspense & Thrillers", 56),
    AUDIOBOOK_TRAVEL("Travel", 57),
    AUDIOBOOK_WESTERN("Western", 58),
    MUSIC_ALTERNATIVE("Alternative", 59),
    MUSIC_BALLET("Ballet", 60),
    MUSIC_BLUES("Blues", 61),
    MUSIC_CHAMBER_MUSIC("Chamber Music", 62),
    MUSIC_CHORAL("Choral", 63),
    MUSIC_CLASSICAL("Classical", 64),
    MUSIC_CONCERTOS("Concertos", 65),
    MUSIC_FILM_MUSIC("Film Music", 66),
    MUSIC_FOLK("Folk", 67),
    MUSIC_INSTRUMENTAL("Instrumental", 68),
    MUSIC_JAZZ("Jazz", 69),
    MUSIC_POP("Pop", 70),
    MUSIC_OPERA_OPERETTA("Opera & Operetta", 71),
    MUSIC_ORCHESTRAL("Orchestral", 72),
    MUSIC_ROCK("Rock", 73),
    MUSIC_VOCAL("Vocal", 74),
    MUSIC_WORLD_MUSIC("World Music", 75);
    
    
    private final String textRep;
    private final int categoryId;
    Category(String textRep,int categoryId) {
        this.textRep = textRep;
        this.categoryId = categoryId;
    }
    
    public String getTextRep() {
        return this.textRep;
    }
    
    public int getCategoryId() {
        return this.categoryId;
    }
}
