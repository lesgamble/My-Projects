package com.techelevator.controller;

import com.techelevator.dao.CatCardDao;
import com.techelevator.model.CatCard;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping(path = "/api/cards")
@RestController
@CrossOrigin


public class CatController {

    private CatCardDao catCardDao;
    private CatFactService catFactService;
    private CatPicService catPicService;

    public CatController(CatCardDao catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }

    @RequestMapping(value = "/random", method = RequestMethod.GET)
    public CatCard getNew() {
        CatCard newCard = new CatCard();
        newCard.setCatFact(catFactService.getFact().getText());
        newCard.setImgUrl(catPicService.getPic().getFile());
        newCard.setCaption("");
        return newCard;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<CatCard> getList() {
        return catCardDao.list();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CatCard getId(@PathVariable int id) {
        return catCardDao.get(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "", method = RequestMethod.POST)
    public CatCard saveCard(@RequestBody CatCard saveCard) {
        catCardDao.save(saveCard);
        return saveCard;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public CatCard updateCard(@RequestBody CatCard updateCard) {
        catCardDao.update(updateCard.getCatCardId(), updateCard);
        return updateCard;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCard(@PathVariable int id) {
        if (catCardDao.get(id) != null) {
            catCardDao.delete(id);
        }
    }

}

