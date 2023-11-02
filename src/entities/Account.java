package entities;

import exceptions.BusinessException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;

	public Account() {
	}

	public Account(Integer unmber, String holder, Double balance, Double withdrawLimit) {
		this.number = unmber;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer unmber) {
		this.number = unmber;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void deposit(Double amount) {
		balance = +amount;
	}

	public void withdraw(Double amount) {
		validateWithdraw(amount);
		balance -= amount;

	}

	public void validateWithdraw(double amount) {
		if (amount > getWithdrawLimit()) {
			throw new BusinessException("Erro de saque: A quantia excede o limite de saque");
		}
		if (amount > getBalance()) {
			throw new BusinessException("Erro de saque: Saldo insuficiente");
		}
	}
}
