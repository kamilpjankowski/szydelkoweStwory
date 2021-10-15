package pl.szydelkowestwory.szydelkoweStwory.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.szydelkowestwory.szydelkoweStwory.model.Zamowienie;

@Repository
public interface ZamowienieDAO extends JpaRepository<Zamowienie,Long> {
}
