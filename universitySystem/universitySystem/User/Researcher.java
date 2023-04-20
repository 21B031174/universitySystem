package universitySystem.User;

import java.util.Date;

public class Researcher implements DoResearch {

	@SuppressWarnings("deprecation")
	@Override
	public RecearchPapers writeArticles(String subject,String overview) {
		// TODO Auto-generated method stub
		Date d = new Date();
		return new RecearchPapers(d.getYear() ,subject, overview);
		
	}

}
