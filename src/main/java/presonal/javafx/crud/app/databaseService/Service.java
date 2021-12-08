package presonal.javafx.crud.app.databaseService;

import presonal.javafx.crud.app.databaseService.DTO.AbstractDTO;
import presonal.javafx.crud.app.entity.AbstractEntity;

public interface Service<E extends AbstractEntity, B extends AbstractDTO> {

	void add(B object);

	E get(B object);

	void delete(B object);

	void update(B object);

}
