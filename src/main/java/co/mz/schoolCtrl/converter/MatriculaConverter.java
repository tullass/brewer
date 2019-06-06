package co.mz.schoolCtrl.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import co.mz.schoolCtrl.model.Matricula;

public class MatriculaConverter implements Converter<String, Matricula> {

	@Override
	public Matricula convert(String id) {
		if (!StringUtils.isEmpty(id)) {
			Matricula subject = new Matricula();
			subject.setId(Long.valueOf(id));
			return subject;
		}
		
		return null;
	}

}
