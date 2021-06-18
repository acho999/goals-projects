import {React,Fragment} from 'react';
import ReactDOM from 'react-dom';//here we add reactdom in order to navigate Backdrop and ModalOverlay to the place where they have to appear
import Card from './Card';
import Button from './Button';
import classes from './ErrorModal.module.css';


const Backdrop = props => {//here we split ErrorModal in to two separate components, we can do it in separate files also
  return <div className={classes.backdrop} onClick={props.onConfirm} />
}

const ModalOverlay = props => {
  return <Card className={classes.modal}>
  <header className={classes.header}>
    <h2>{props.title}</h2>
  </header>
  <div className={classes.content}>
    <p>{props.message}</p>
  </div>
  <footer className={classes.actions}>
    <Button onClick={props.onConfirm}>Okay</Button>
  </footer>
</Card>
}

const ErrorModal = (props) => {
  return (
    <Fragment>
      {ReactDOM.createPortal(<Backdrop onConfirm={props.onConfirm}/>, document.getElementById('backdrop-modal'))}
      {/*here we tell what component where to be added as get the element in Index.html by id*/}
      {ReactDOM.createPortal(<ModalOverlay title={props.title} message = {props.message} onConfirm={props.onConfirm}/>, document.getElementById('overlay-root'))}
      
    </Fragment>
  );
};

export default ErrorModal;
