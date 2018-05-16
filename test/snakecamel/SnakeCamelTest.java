package snakecamel;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class SnakeCamelTest {

	@Test
	public void 三文字の先頭だけ大文字にする() {
		SnakeCamelUtil scu = new SnakeCamelUtil();
		String expected = "Abc";
		String actual = scu.snakeToCamelcase("abc");
		assertThat(actual, is(expected));
	}
	
	@Test
	public void 三文字ずつに区切られた六文字のそれぞれ先頭を大文字にする() {
		SnakeCamelUtil scu = new SnakeCamelUtil();
		String expected = "AbcDef";
		String actual = scu.snakeToCamelcase("abc_def");
		assertThat(actual, is(expected));
	}
	
	@Test
	public void 三文字ずつに区切られた九文字のそれぞれ先頭を大文字にする() {
		SnakeCamelUtil scu = new SnakeCamelUtil();
		String expected = "AbcDefGh";
		String actual = scu.snakeToCamelcase("abc_def_gh");
		assertThat(actual, is(expected));
	}
	
	@Test
	public void 三文字ずつ区切るアンダーバーを増やしても先頭が大文字になる() {
		SnakeCamelUtil scu = new SnakeCamelUtil();
		String expected = "AbcDefGh";
		String actual = scu.snakeToCamelcase("abc__def___gh");
		assertThat(actual, is(expected));
	}
	
	@Test
	public void アンダーバーが初めにあっても3文字ずつの先頭だけ大文字になる() {
		SnakeCamelUtil scu = new SnakeCamelUtil();
		String expected = "AbcDef";
		String actual = scu.snakeToCamelcase("_abc_def__");
		assertThat(actual, is(expected));
	}
	
	@Test
	public void 三文字の先頭だけ小文字になる() {
		SnakeCamelUtil scu = new SnakeCamelUtil();
		String expected = "abc";
		String actual = scu.camelToSnakecase("Abc");
		assertThat(actual, is(expected));
	}
	
	@Test
	public void 大文字があればそれを小文字にしてアンダーバーで区切る() {
		SnakeCamelUtil scu = new SnakeCamelUtil();
		String expected = "abc_def";
		String actual = scu.camelToSnakecase("AbcDef");
		assertThat(actual, is(expected));
	}
	
	@Test
	public void 九文字の中で大文字があればそれを小文字にしてアンダーバーで区切る() {
		SnakeCamelUtil scu = new SnakeCamelUtil();
		String expected = "abc_def_gh";
		String actual = scu.camelToSnakecase("AbcDefGh");
		assertThat(actual, is(expected));
	}
	
	@Test
	public void 空文字から空文字にする() {
		SnakeCamelUtil scu = new SnakeCamelUtil();
		String expected = "";
		String actual = scu.capitalize("");
		assertThat(actual, is(expected));
	}
	
	@Test
	public void 一文字だけ大文字にする() {
		SnakeCamelUtil scu = new SnakeCamelUtil();
		String expected = "A";
		String actual = scu.capitalize("a");
		assertThat(actual, is(expected));
	}
	
	@Test
	public void capitalizeで文字列の初めを大文字にする() {
		SnakeCamelUtil scu = new SnakeCamelUtil();
		String expected = "Xyz";
		String actual = scu.capitalize("xyz");
		assertThat(actual, is(expected));
	}
	
	@Test
	public void uncapitalizeで文字列の初めを小文字にする() {
		SnakeCamelUtil scu = new SnakeCamelUtil();
		String expected = "xyz";
		String actual = scu.uncapitalize("Xyz");
		assertThat(actual, is(expected));
	}
	
	@Test
	public void 空文字から空文字() {
		SnakeCamelUtil scu = new SnakeCamelUtil();
		String expected = "";
		String actual = scu.uncapitalize("");
		assertThat(actual, is(expected));
	}
	
	@Test
	public void 一文字だけ小文字にする() {
		SnakeCamelUtil scu = new SnakeCamelUtil();
		String expected = "a";
		String actual = scu.uncapitalize("A");
		assertThat(actual, is(expected));
	}

}
