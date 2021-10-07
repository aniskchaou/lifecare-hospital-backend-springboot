package com.dev.delta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.entities.Document;
import com.dev.delta.exceptions.DocumenNotFound;
import com.dev.delta.repositories.DocumentRepository;


@Service
public class DocumentService {
	@Autowired
	DocumentRepository  documentRepository;
	
	public Document saveOrUpdate(Document document)
	{
		
		return documentRepository.save(document);
	}
	
	public Iterable<Document> findAll()
	{
		return documentRepository.findAll();
	}
	
	public Document findById(Long id)
	{
		return documentRepository.findById(id).orElseThrow(()->new DocumenNotFound("Document Not found."));
	}
	
	public void delete(Long id)
	{
		Document document=findById(id);
		documentRepository.delete(document);
	}
}
