package org.zeti.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zeti.medical.entity.UserAccount;
import org.zeti.medical.repository.custom.UserAccountCustomRepository;
public interface UserAccountRepository extends JpaRepository<UserAccount, Integer>, UserAccountCustomRepository
{
    @Query(value = "SELECT u.password from UserAccount u where u.password = (:password)")
    String findPasswordByPassword(@Param(value = "password") String password);

    boolean existsByUsername(String username);

    boolean existsByPassword(String password);
}
