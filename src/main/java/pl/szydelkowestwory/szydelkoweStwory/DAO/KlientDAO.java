package pl.szydelkowestwory.szydelkoweStwory.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.szydelkowestwory.szydelkoweStwory.model.Klient;

@Repository
public interface KlientDAO extends JpaRepository<Klient,Long> {

}
