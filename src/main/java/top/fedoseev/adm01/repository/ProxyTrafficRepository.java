package top.fedoseev.adm01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import top.fedoseev.adm01.model.Traffic;

import java.util.List;

@Transactional(readOnly = true)
public interface ProxyTrafficRepository extends JpaRepository<Traffic, Integer> {

   /* @Transactional
    @Modifying
    @Query("DELETE FROM Traffic u WHERE u.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Transactional
    Traffic save(Traffic traffic);*/

    @Override
    @Query("SELECT t FROM Traffic t WHERE t.id=:id")
    Traffic findOne(Integer id);

    @Override
    @Query("SELECT DISTINCT t FROM Traffic t ORDER BY t.date")
    List<Traffic> findAll();

}