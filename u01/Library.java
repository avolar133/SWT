public class Library {

   private Book [] myBooks;

   private int number;

   public Library() {
       myBooks = new Book[10];
       number = 0;
       System.out.println("Hello, I am a library, which can store up to 10 books!");
       }

   public void add(Book book) {
       if(number >= 10){
	   System.out.println("The library is full!");
       }else{
	   myBooks[number] = book;
	   number += 1;
	   System.out.println("I added the book " + book.getTitle());
       }
       
    }

    public Book search(String title){
	for(int i = 0 ; i < number; i ++){
	    Book b = myBooks[i];
	    if(b.getTitle().equals(title) == true){
		System.out.println("The book with the title "+ title + " exists in the library!");
		return b;
	    }
	}
	System.out.println("The book with the title" + title + " does not exist in the library!");
	return null;
    }
    
    public boolean loan(String title){
	Book b = search(title);

	if(b == null){
	    System.out.println("The book " + title + " is not found" );
	    return false;
	}else{
	    if(b.getState() == true){
		System.out.println("The book " + title + "is lent");
		return false;
	    }else{
		b.setState(true);
	       	System.out.println("The book " + title + "is available");
		return true;
	    }
	}
    }
    
}




