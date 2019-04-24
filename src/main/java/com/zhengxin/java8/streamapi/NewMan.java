package com.zhengxin.java8.streamapi;

import com.zhengxin.java8.streamapi.Godness;

import java.util.Optional;

//注意：Optional 不能被序列化
public class NewMan {

	private Optional<Godness> godness = Optional.empty();
	

	public NewMan() {
	}

	public NewMan(Godness godness){
		this.godness = Optional.ofNullable(godness);
	}

	public NewMan(Optional<Godness> godness) {
		this.godness = godness;
	}

	public Optional<Godness> getGodness() {
		return godness;
	}

	public void setGodness(Optional<Godness> godness) {
		this.godness = godness;
	}

	@Override
	public String toString() {
		return "NewMan [godness=" + godness + "]";
	}

}
