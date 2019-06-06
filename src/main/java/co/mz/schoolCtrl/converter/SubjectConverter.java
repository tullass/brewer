package co.mz.schoolCtrl.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import co.mz.schoolCtrl.model.Subject;

public class SubjectConverter implements Converter<String, Subject> {

	@Override
	public Subject convert(String id) {
		if (!StringUtils.isEmpty(id)) {
			Subject subject = new Subject();
			subject.setId(Long.valueOf(id));
			return subject;
		}
		
		return null;
	}

}
