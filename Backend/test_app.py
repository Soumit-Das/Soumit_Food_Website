import pytest
from app import create_app


@pytest.fixture
def app():
    return create_app()


@pytest.fixture
def client(app):
    return app.test_client()


def test_addSnack(client):
    data = {"name":"Leg piece of cheetah" , "price":200 , "availability" : "available"}
    response = client.post("/addsnack" , json=data)
    assert response.status_code == 201
    # assert response.get_json() == {'availability': 'available', 'id': 10, 'name': 'Kumirer mathar murighonto', 'price': 200.0}



def test_viewsnack(client):
    response = client.get("/viewsnack")
    assert response.status_code == 200



def test_updatesnack(client):
    newdata = {"name":"Dinosaurs Egg Omlete" , "price":300.0 , "availability" : "available"} 
    response = client.put("/updatesnack/31", json=newdata)
    assert response.status_code == 200
    # assert response.get_json() == {'id': 24, 'name': 'Dinosaurs Egg Omlete', 'price': 300.0 ,'availability':'available'}   



def test_delete(client):
    response = client.delete("/deletesnack/32")
    assert response.status_code == 200
    assert response.get_json() == {'message': 'Snack deleted successfully'}

