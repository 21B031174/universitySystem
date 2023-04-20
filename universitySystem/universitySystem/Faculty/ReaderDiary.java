package universitySystem.Faculty;

import java.util.Date;
import java.util.Map;

/**
* @generated
*/

public class ReaderDiary {
    
    private Map<Book, Map<Date, Date>> diary;
    
    public Map<Book, Map<Date, Date>> getDiary() {
        return this.diary;
    }
    
    public void setDiary(Map<Book, Map<Date, Date>> diary) {
        this.diary = diary;
    }
    
}
