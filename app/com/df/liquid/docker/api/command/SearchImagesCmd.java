package com.df.liquid.docker.api.command;



import java.util.List;

import com.df.liquid.docker.api.model.SearchItem;

/**
 * Search images
 *
 * @param term - search term
 *
 */
public interface SearchImagesCmd extends DockerCmd<List<SearchItem>> {

	public String getTerm();

	public SearchImagesCmd withTerm(String term);
	
	public static interface Exec extends DockerCmdExec<SearchImagesCmd, List<SearchItem>> {
	}

}