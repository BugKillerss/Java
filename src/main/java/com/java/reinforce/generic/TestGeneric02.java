package com.java.reinforce.generic;

interface Task<Param,Result>{
	/**
	 *�˷�������ִ������
	 *@Param arg �������ɷ��Ͳ���Param����
	 *@Return ��������result����
	 */
		Result execute(Param arg);	
	
}
	class AsyncTask implements Task<Integer,Integer>{//�ô���ʵ��Task�ӿ�

		public Integer execute(Integer arg) {
			int result=0;
			for(int i=0;i<=arg;i++) {
				if(i%2!=0) {
					result+=i;
				}
			}
			return result;
		}
	}
	abstract class ConvertTask<Param,Result> implements
	Task<Param,Result>{
		public abstract Result execute(Param arg);
		

	public static void main(String[] args) {
		AsyncTask ac=new AsyncTask();
		Integer i=ac.execute(10);
		System.out.println(i);
		
		ConvertTask<String,Integer> c=new ConvertTask<String,Integer>() {
			@Override
			public Integer execute(String arg) {
				return Integer.parseInt(arg);
			}
			
		};
				
			
	}
	
}





