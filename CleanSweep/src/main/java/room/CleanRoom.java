package room;

public enum CleanRoom {
	
		DIRTY	{
			@Override
			public String toString(){
				return "dirty";
			}
		
	}, CLEAN	{
		@Override
		public String toString(){
			return "clean";
		}
	
}
	
}
