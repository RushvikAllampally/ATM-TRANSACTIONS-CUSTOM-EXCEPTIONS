package Practice;
import java.util.*;

public class Bank {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Map<Integer,int[]> map = new HashMap<>();
		map.put(38002391,new int[] {1928,2400});
		map.put(38002394,new int[] {4928,3200});
		map.put(34002393,new int[] {1528,2800});
		map.put(35002392,new int[] {1968,2700});
		map.put(33002390,new int[] {1568,200});
		
		Scanner in = new Scanner(System.in);
		
		int status = printMenu();
		
		while(status != 4) {
			
			
			switch(status) {
			case 1:
				
				try {
					balance(map);
				} catch (IncorrectActNumberException e1) {
					// TODO Auto-generated catch block
					System.out.println("Entered Incorrect account Number");
				} catch (inCorrectCvvException e1) {
					// TODO Auto-generated catch block
					System.out.println("Entered Incorrect CVV");
				}
							
				break;
			case 2:
				
				try {
					withDrawMoney(map);
				} catch (IncorrectActNumberException e1) {
					// TODO Auto-generated catch block
					System.out.println("Entered Incorrect account Number");
				} catch (inCorrectCvvException e1) {
					// TODO Auto-generated catch block
					System.out.println("Entered Incorrect CVV");
				} catch (inSufficientFundsException e1) {
					// TODO Auto-generated catch block
					System.out.println("Insufficient Funds, enter a lesser number");
				}
				
				break;
			case 3:
				
				try {
					map=depositMoney(map);
				} catch (IncorrectActNumberException e1) {
					// TODO Auto-generated catch block
					System.out.println("Entered Incorrect account Number");
				} catch (inCorrectCvvException e1) {
					// TODO Auto-generated catch block
					System.out.println("Entered Incorrect CVV");
				}
				break;
			case 4:
				status =4;
				break;
			}
			
			status = printMenu();
			
				
			
		}
		System.out.println("Thank you for bancking with us !!");
		
	}
	
	private static Map<Integer, int[]> depositMoney(Map<Integer, int[]> map) throws IncorrectActNumberException, inCorrectCvvException{
		// TODO Auto-generated method stub
		System.out.println("Enter the card number");
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		if(map.containsKey(num)) {
			System.out.println("enter the amount to be deposited");
			int amt =in.nextInt();
			System.out.println("Enter CVV of card");
			int cvv = in.nextInt();
			int balance = map.get(num)[1];
			if(map.get(num)[0] == cvv ) {
				balance = balance + amt;
				System.out.println("Amount Deposited Successfully,balance is :"+ balance);
			}else {
				throw new inCorrectCvvException("Wrong CVV entered");
			}
			
			map.put(num,new int[]{cvv,balance});
		
		}else {
			throw new IncorrectActNumberException("Entered Incorrect Card Number");
		}
		
		return map;
	}

	private static Map<Integer, int[]> withDrawMoney(Map<Integer, int[]> map) throws IncorrectActNumberException, inCorrectCvvException, inSufficientFundsException {
		System.out.println("Enter the card number");
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		if(map.containsKey(num)) {
			System.out.println("Enter CVV of card");
			int cvv = in.nextInt();
			int balance = map.get(num)[1];
			if(map.get(num)[0] == cvv ) {
				System.out.println("enter the amount to be withdrawed");
				int amt =in.nextInt();
				if(amt <= map.get(num)[1]) {
					System.out.println("AMOUNT WITHDRAWED, COLLECT CASH Rupees:"+ amt);
				}else {
					throw new inSufficientFundsException("Insufficient funds , Enter lesser amount");
				}
				
				balance = balance - amt;
			}else {
				throw new inCorrectCvvException("Wrong CVV entered");
			}
			
			map.put(num,new int[]{cvv,balance});
		
		}else {
			throw new IncorrectActNumberException("Entered Incorrect Card Number");
		}
		
		return map;
	}

	public static int printMenu() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Hello, Welcome to Rushvik ATM");
		System.out.println("Please select one of the below options");
		System.out.println("1 - Check bank balance");
		System.out.println("2 - Withdraw money");
		System.out.println("3 - Deposit money");
		System.out.println("4 - exit");
		int status = in.nextInt();
		
		return status;
	}
	
	public static void balance(Map<Integer,int[]> map) throws IncorrectActNumberException, inCorrectCvvException {
		
			System.out.println("Enter the card number");
			Scanner in = new Scanner(System.in);
			int num = in.nextInt();
			if(map.containsKey(num)) {
				System.out.println("Enter CVV of card");
				int cvv = in.nextInt();
				if(map.get(num)[0] == cvv ) {
					System.out.println(map.get(num)[1]);
				}else {
					throw new inCorrectCvvException("Wrong CVV entered");
				}
				
			}else {
				throw new IncorrectActNumberException("Entered Incorrect Account Number");
			}
	}
	
	

}
