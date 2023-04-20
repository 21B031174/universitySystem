package universitySystem.User;

import java.util.Date;

public class UserResearcher implements DoResearch {

	@Override
	public RecearchPapers writeArticles(String subject, String overview) {
		Date d = new Date();
		RecearchPapers r = new RecearchPapers(d.getYear(),subject,overview);
		return r;
	}
	
}
