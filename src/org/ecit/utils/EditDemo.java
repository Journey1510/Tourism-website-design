package org.ecit.utils;

/**
 * 字符串编辑距离
 * 
 * 这是一种字符串之间相似度计算的方法。 给定字符串S、T，将S转换T所需要的插入、删除、替代操作的数量叫做S到T的编辑路径。 其中最短的路径叫做编辑距离。
 * 
 * 这里使用了一种动态规划的思想求编辑距离。
 * 
 * @author heartraid
 *
 */
public class EditDemo {

	public int edit(String strX, int startX, int endX, String strY, int startY,
			int endY) {
		char[] charArrayX = strX.toCharArray();
		char[] charArrayY = strY.toCharArray();
		if (startX > endX) {
			if (startY > endY) {
				return 0;
			} else {
				return endY - startY + 1;
			}
		}

		if (startY > endY) {
			if (startX > endX) {
				return 0;
			} else {
				return endX - startY + 1;
			}
		}

		if (charArrayX[endX] == charArrayY[endY]) {
			return edit(strX, startX, endX - 1, strY, startY, endY - 1);
		} else {
			int t1 = edit(strX, startX, endX - 1, strY, startY, endY);
			int t2 = edit(strX, startX, endX, strY, startY, endY - 1);
			int t3 = edit(strX, startX, endX - 1, strY, startY, endY - 1);
			t1 = t1 < t2 ? t1 : t2;
			return (t1 < t3 ? t1 : t3) + 1;
		}
	}

	public int edit(String strX, String strY) {
		return edit(strX, 0, strX.length()-1, strY, 0, strY.length()-1);
	}

	
	
	public double cosine(String strX,String strY){
		char[] charArrayX=strX.toCharArray();
		char[] charArrayY=strY.toCharArray();
		for(char charX:charArrayX){
			for(char charY:charArrayY){
				
			}
		}
		return 0;
		
	}
	/**
	 * 测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EditDemo editDemo = new EditDemo();
		int n = editDemo.edit("周杰伦是一个歌手,也是一个叉叉", "周杰伦不是一个叉叉，但是是一个歌手");
		System.out.println("编辑距离为：" + n);
	}

}
