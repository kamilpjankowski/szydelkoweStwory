package pl.szydelkowestwory.szydelkoweStwory.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.szydelkowestwory.szydelkoweStwory.model.Maskotka;

@Repository
public interface MaskotkaDAO extends JpaRepository<Maskotka,Long> {

}
