package mil.yaye.yours.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class PageHelper {

	private static Logger log = Logger.getLogger(PageHelper.class.getName());
	private int pageSize;
	private int currentPage;
	private int totalRecord;
	private int totalPage;
	private int nextPage;
	private int prevPage;
	private List<Integer> list = new ArrayList<Integer>();
	private Map paras = new HashMap();
	
	public PageHelper(int currentPage, int pageSize, int totalRecord, int paginatebarsize) {
		this.totalRecord = totalRecord;
		this.pageSize = pageSize;
		if (totalRecord != 0) {
			this.totalPage = (totalRecord + pageSize - 1)  / pageSize;
			this.currentPage = currentPage;
			this.prevPage = (this.currentPage - 1 <= 0) ? 1 : (this.currentPage -1);
			this.nextPage = (this.currentPage + 1 >= totalPage) ? totalPage : (this.currentPage + 1);
			this.setList(this.totalPage, paginatebarsize);
		} else {
			this.currentPage = 0;
			this.totalRecord = 0;
			this.totalPage = 0;
			this.nextPage = 0;
			this.prevPage = 0;
//			this.currentTotalRecord = 0;
		}

	}

	public int getPageSize() {
		return pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public int getPrevPage() {
		return prevPage;
	}
	
	public List<Integer> getList() {
		return list;
	}
	
	public void setList(List<Integer> list) {
		this.list = list;
	}
	public void setList_6(int totalPage, int paginatebarsize) {
		if(currentPage > (paginatebarsize - 1)){
			if(currentPage % (paginatebarsize - 1) == 1){
				if((totalPage - currentPage + 1) < paginatebarsize){
					for(int i = 0; i < (totalPage - currentPage) + 1; i++){
						list.add(currentPage + i);
					}
				}else{
					for(int i = 0; i < paginatebarsize; i++){
						list.add(currentPage + i);
					}
				}
			}else if(currentPage % (paginatebarsize - 1) == 0){
				for(int i = 1; i < (((currentPage-1) % (paginatebarsize - 1)) + 1); i++){ //这里有问题因为对于可以整除,余数为0的情况就又改变了算法了..
					list.add(currentPage - (((currentPage-1) % (paginatebarsize - 1) + 1) - i));
				}
				if((totalPage - currentPage + 1) < ((paginatebarsize - 1) + 1)){
					for(int i = 0; i < (totalPage - currentPage) + 1; i++){
						list.add(currentPage + i);
					}
				}else{
					for(int i = 0; i < paginatebarsize - ((currentPage -1) % (paginatebarsize - 1)); i++){
						list.add(currentPage + i);
					}
				}
			}else{
				for(int i = 1; i < currentPage % (paginatebarsize - 1); i++){
					list.add(currentPage - (currentPage % (paginatebarsize - 1) - i));
				}
				if((totalPage - currentPage + 1) < ((paginatebarsize - 1) + 1)){
					for(int i = 0; i < (totalPage - currentPage) + 1; i++){
						list.add(currentPage + i);
					}
				}else{
					for(int i = 0; i < ((paginatebarsize - 1) + 1) - (currentPage % (paginatebarsize - 1) - 1); i++){
						list.add(currentPage + i);
					}
				}
			}
		} else {
			if(totalPage < (paginatebarsize - 1)){
				for(int i = 0; i < totalPage; i++){
					list.add(i+1);
				}
			}else{
				for(int i = 0; i < (paginatebarsize - 1) + 1; i++){
					list.add(i+1);
				}
			}
		}
	}
	public void setList(int totalPage, int paginatebarsize) {
		if(currentPage >= paginatebarsize){
			if(currentPage % (paginatebarsize - 1) == 1){
				if((totalPage - currentPage + 1) < paginatebarsize){
					for(int i = 0; i < (totalPage - currentPage) + 1; i++){
						list.add(currentPage + i);
					}
				}else{
					for(int i = 0; i < paginatebarsize; i++){
						list.add(currentPage + i);
					}
				}
			}else if(currentPage % (paginatebarsize - 1) == 0){
				for(int i = 1; i < (((currentPage-1) % (paginatebarsize - 1)) + 1); i++){ //这里有问题因为对于可以整除,余数为0的情况就又改变了算法了..
					list.add(currentPage - (((currentPage-1) % (paginatebarsize - 1) + 1) - i));
				}
				if((totalPage - currentPage + 1) < ((paginatebarsize - 1) + 1)){
					for(int i = 0; i < (totalPage - currentPage) + 1; i++){
						list.add(currentPage + i);
					}
				}else{
					for(int i = 0; i < paginatebarsize - ((currentPage -1) % (paginatebarsize - 1)); i++){
						list.add(currentPage + i);
					}
				}
			}else{
				for(int i = 1; i < currentPage % (paginatebarsize - 1); i++){
					list.add(currentPage - (currentPage % (paginatebarsize - 1) - i));
				}
				if((totalPage - currentPage + 1) < ((paginatebarsize - 1) + 1)){
					for(int i = 0; i < (totalPage - currentPage) + 1; i++){
						list.add(currentPage + i);
					}
				}else{
					for(int i = 0; i < ((paginatebarsize - 1) + 1) - (currentPage % (paginatebarsize - 1) - 1); i++){
						list.add(currentPage + i);
					}
				}
			}
		} else {
			if(totalPage < paginatebarsize){
				for(int i = 0; i < totalPage; i++){
					list.add(i+1);
				}
			}else{
				for(int i = 0; i < paginatebarsize; i++){
					list.add(i+1);
				}
			}
		}
	}
	public Object getParameter(String key) {

		return paras.get(key);
	}
	public void addParameter(String key, Object value) {
		paras.put(key, value);
	}


}
