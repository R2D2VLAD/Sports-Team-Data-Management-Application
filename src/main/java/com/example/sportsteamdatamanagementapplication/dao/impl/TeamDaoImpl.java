package com.example.sportsteamdatamanagementapplication.dao.impl;

import com.example.sportsteamdatamanagementapplication.dao.TeamDao;
import com.example.sportsteamdatamanagementapplication.model.Team;
import com.example.sportsteamdatamanagementapplication.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TeamDaoImpl implements TeamDao {

    @Override
    public List<Team> findAllTeam() {  //Получить все команды
        return (List<Team>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Team").list();
    }

    @Override
    public void addTeam(Team team) {  //Добавить команду
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(team);
        tx1.commit();
        session.close();
    }

    @Override
    public void updateTeam(Team team) {  //Изменение данных команды
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(team);
        tx1.commit();
        session.close();
    }

    @Override
    public void deleteTeam(Team team) {   //Удаление команды
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(team);
        tx1.commit();
        session.close();
    }
}
