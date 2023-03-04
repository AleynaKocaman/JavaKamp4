package Kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;
import Kodlama.io.Devs.entities.concretes.Language;

public interface LanguageRepository {

	void add(Language language);

	void delete(Language language);

	List<Language> getAll();

	Language getById(int id);

	void update(int id, Language language);

}
