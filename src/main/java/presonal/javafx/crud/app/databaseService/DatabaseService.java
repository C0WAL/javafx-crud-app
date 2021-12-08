package presonal.javafx.crud.app.databaseService;

import org.hibernate.Session;
import org.hibernate.Transaction;

import presonal.javafx.crud.app.databaseService.DTO.AbstractDTO;
import presonal.javafx.crud.app.entity.AbstractEntity;
import presonal.javafx.crud.app.exceptions.BadInputException;
import presonal.javafx.crud.app.exceptions.DatabaseTransactionException;

public abstract class DatabaseService<E extends AbstractEntity, D extends AbstractDTO> implements Service<E, D> {

	public abstract E convert(D object);

	public abstract boolean validate(D object);

	@Override
	public void add(D object) {
		Session session = SessionBuilder.getSession();
		E entity = convert(object);
		if (validate(object) == true) {
			throw new BadInputException("Given object already exists in database");
		}
		try {
			Transaction t = session.beginTransaction();
			session.save(entity);
			t.commit();
		} catch (Exception e) {
			throw new DatabaseTransactionException("Error while adding rate object to database", e);
		}
	}

	@Override
	public void delete(D object) {
		Session session = SessionBuilder.getSession();
		E entity;
		try {
			entity = get(object);
			if (entity != null) {
				Transaction t = session.beginTransaction();
				session.delete(entity);
				t.commit();
			} else {
				throw new BadInputException("Such object does not exist");
			}
		} catch (Exception e) {
			throw new DatabaseTransactionException(
					"Error while deleting object matching requested data: (" + object.toString() + ")");
		}
	}
}
