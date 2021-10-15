package pl.szydelkowestwory.szydelkoweStwory.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.szydelkowestwory.szydelkoweStwory.model.Material;

@Repository
public interface MaterialDAO extends JpaRepository<Material,Long> {
}
