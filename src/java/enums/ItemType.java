package enums;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ricky
 */
public enum ItemType {
    EBOOK("eBook", 1, new Category[]{Category.ART_ANTIQUES_COLLECTIBLES, Category.BIOGRAPHY, Category.BUSINESS_INVESTING, Category.CAREERS_INVESTING
    , Category.CLASSIC_LITERATURE, Category.COMPUTERS_TECHNOLOGY, Category.COOKING_FOOD, Category.CURRENT_EVENTS_POLITICS, Category.DRAMA
    , Category.FOREIGN_LANGUAGE_STUDY, Category.HEALTH_FITNESS, Category.HISTORICAL_FICTION, Category.HISTORY, Category.HOME_FAMILY
    , Category.HORROR, Category.HUMOR, Category.LITERARY_CRITICISM, Category.MYSTERY, Category.POETRY, Category.PROFESSIONAL, Category.RELIGION_SPIRITUALITY
    , Category.ROMANCE, Category.SCIENCE_FICTION_FANTASY, Category.SELF_IMPROVEMENT, Category.SPORTS_RECREATION, Category.STUDY_AIDS_REFERENCE
    , Category.SUSPENSE_THRILLERS, Category.TRAVEL, Category.WESTERN}),
    AUDIOBOOK("Audiobook", 2, new Category[]{Category.AUDIOBOOK_ART_ANTIQUES_COLLECTIBLES, Category.AUDIOBOOK_BIOGRAPHY, Category.AUDIOBOOK_BUSINESS_INVESTING, Category.AUDIOBOOK_CAREERS_INVESTING
    , Category.AUDIOBOOK_CLASSIC_LITERATURE, Category.AUDIOBOOK_COMPUTERS_TECHNOLOGY, Category.AUDIOBOOK_COOKING_FOOD, Category.AUDIOBOOK_CURRENT_EVENTS_POLITICS, Category.AUDIOBOOK_DRAMA
    , Category.AUDIOBOOK_FOREIGN_LANGUAGE_STUDY, Category.AUDIOBOOK_HEALTH_FITNESS, Category.AUDIOBOOK_HISTORICAL_FICTION, Category.AUDIOBOOK_HISTORY, Category.AUDIOBOOK_HOME_FAMILY
    , Category.AUDIOBOOK_HORROR, Category.AUDIOBOOK_HUMOR, Category.AUDIOBOOK_LITERARY_CRITICISM, Category.AUDIOBOOK_MYSTERY, Category.AUDIOBOOK_POETRY, Category.AUDIOBOOK_PROFESSIONAL, Category.AUDIOBOOK_RELIGION_SPIRITUALITY
    , Category.AUDIOBOOK_ROMANCE, Category.AUDIOBOOK_SCIENCE_FICTION_FANTASY, Category.AUDIOBOOK_SELF_IMPROVEMENT, Category.AUDIOBOOK_SPORTS_RECREATION, Category.AUDIOBOOK_STUDY_AIDS_REFERENCE
    , Category.AUDIOBOOK_SUSPENSE_THRILLERS, Category.AUDIOBOOK_TRAVEL, Category.AUDIOBOOK_WESTERN}),
    MUSIC("Music", 3, new Category[]{Category.MUSIC_ALTERNATIVE, Category.MUSIC_BALLET, Category.MUSIC_BLUES, Category.MUSIC_CHAMBER_MUSIC
    , Category.MUSIC_CHORAL, Category.MUSIC_CLASSICAL, Category.MUSIC_CONCERTOS, Category.MUSIC_FILM_MUSIC, Category.MUSIC_FOLK
    , Category.MUSIC_INSTRUMENTAL, Category.MUSIC_JAZZ, Category.MUSIC_OPERA_OPERETTA, Category.MUSIC_ORCHESTRAL, Category.MUSIC_POP
    , Category.MUSIC_ROCK, Category.MUSIC_VOCAL, Category.MUSIC_WORLD_MUSIC});
    
    private final String textRep;
    private final int typeId;
    private final Category[] categoryForType;
    
    ItemType(String textRep, int typeId, Category[] categoryForType) {
        this.textRep = textRep;
        this.typeId = typeId;
        this.categoryForType = categoryForType;
    }
    
    public String getTextRep() {
        return this.textRep;
    }
    
    public int getTypeId() {
        return this.typeId;
    }
    
    public Category[] getCategoriesForType() {
        return categoryForType;
    }
}
