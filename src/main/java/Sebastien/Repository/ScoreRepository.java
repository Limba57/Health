package Sebastien.Repository;


import Sebastien.Entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ScoreRepository extends JpaRepository<Score,Integer> {
}
