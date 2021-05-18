package model;

import java.time.LocalTime;

public class Patient implements Comparable<Patient>{

	
	/**
	 * Informazioni sul paziente--> WORLD MODEL
	 */
	
	private LocalTime arrivalTime;
	
	public enum ColorCode{
		NEW, //IN TRIAGE, ipotizziamo non ci sia coda al triage
		WHITE, YELLOW, RED, BLACK, //in sala di attesa
		TREATING, //sono dentro lo studio medico
		OUT //a casa(abbandonato o curato)
	};
	
	private ColorCode color;
	private int num;

	public Patient(int num, LocalTime arrivalTime, ColorCode color) {
		super();
		this.num=num;
		this.arrivalTime = arrivalTime;
		this.color = color;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public ColorCode getColor() {
		return color;
	}

	public void setColor(ColorCode color) {
		this.color = color;
	}

	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "Patient [arrivalTime=" + arrivalTime + ", color=" + color + ", num=" + num + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		if (num != other.num)
			return false;
		return true;
	}

	@Override
	public int compareTo(Patient other) {
		if(this.color.equals(other.color)) {
			return this.arrivalTime.compareTo(other.arrivalTime);
		}
		else if (this.color.equals(Patient.ColorCode.RED))
		return -1;
		else if(other.color.equals(Patient.ColorCode.RED))
		return +1;
		else if(this.color.equals(Patient.ColorCode.YELLOW))
			return -1;
		else
			return +1;
		
		
	}

	
	
	
	//nella coda degli eventi avrò il timeout, quindi non lo metto qui--> è una freccai che porta da uno stato all'altro.
}
