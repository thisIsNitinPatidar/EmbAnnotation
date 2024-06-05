package com.Embeddable;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App
{
	public static void main(String[] args) throws IOException
	{
		Configuration cfg = new Configuration();
		cfg.configure("configure.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();

		Employee emp = new Employee();
		emp.setEmpid(2);
		emp.setEmpName("monika");
		emp.setDesgn("Lidder");

		Bank bank = new Bank();
		bank.setBid(34);
		bank.setbName("SBI");
		emp.setBank(bank);

		Employee emp1 = new Employee();
		emp1.setEmpid(3);
		emp1.setEmpName("minakshi");
		emp1.setDesgn("manager");

		Bank bank1 = new Bank();
		bank1.setBid(35);
		bank1.setbName("ICICI");
		emp1.setBank(bank1);

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(emp);
		session.save(emp1);
		tx.commit();
		session.close();
		factory.close();
	}
}
