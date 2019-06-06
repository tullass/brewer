package co.mz.schoolCtrl.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import co.mz.schoolCtrl.model.Classe;

public class ClasseConverter implements Converter<String, Classe> {

	@Override
	public Classe convert(String id) {
		if (!StringUtils.isEmpty(id)) {
			Classe subject = new Classe();
			subject.setId(Long.valueOf(id));
			return subject;
		}
		
		return null;
	}

}
