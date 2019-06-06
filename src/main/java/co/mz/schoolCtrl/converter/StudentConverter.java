package co.mz.schoolCtrl.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import co.mz.schoolCtrl.model.Student;

public class StudentConverter implements Converter<String, Student> {

	@Override
	public Student convert(String id) {
		if (!StringUtils.isEmpty(id)) {
			Student subject = new Student();
			subject.setId(Long.valueOf(id));
			return subject;
		}
		
		return null;
	}

}
