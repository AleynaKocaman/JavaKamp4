package Kodlama.io.Devs.business.concretes;

import java.util.List;
import org.springframework.stereotype.Service;
import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {

	private LanguageRepository languageRepository;

	public LanguageManager(LanguageRepository languageRepository) {
		super();
		this.languageRepository = languageRepository;
	}

	public List<Language> getAll() {

		return languageRepository.getAll();
	}

	public Language getById(int id) {

		return languageRepository.getById(id);
	}

	@Override
	public void add(Language language) throws Exception {

		if (language.getName().length() == 0) {
			throw new Exception("Language name cannot be null");
		} else if (languageRepository.getAll().stream().anyMatch(l -> l.getName().equals(language.getName()))) {
			throw new Exception("Language already exists");
		} else {
			languageRepository.add(language);
		}

	}

	@Override
	public void delete(Language language) {
		// TODO Auto-generated method stub
		languageRepository.delete(language);

	}

	@Override
	public void update(int id, Language language) throws Exception {
		// TODO Auto-generated method stub
        if(languageRepository.getAll().contains(language)) {
            throw new Exception("Önceki dil ismi kullanılamaz");
        }else{
                languageRepository.update(id,language);
            }
		
	}

}
